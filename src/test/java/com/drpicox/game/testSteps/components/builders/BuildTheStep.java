package com.drpicox.game.testSteps.components.builders;

import com.drpicox.game.components.builder.BuilderFactory;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.containeds.ContainedTestView;
import com.drpicox.game.testSteps.components.typeds.TypedTestView;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuildTheStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;
    private final BuilderTestView builderTestView;
    private final ContainedTestView containedTestView;
    private final ScreenStackTestView screenStackTestView;
    private final TypedTestView typedTestView;
    private final List<BuilderFactory> builderFactories;

    public BuildTheStep(EntityTestView entityTestView, BuilderTestView builderTestView, ContainedTestView containedTestView, ScreenStackTestView screenStackTestView, TypedTestView typedTestView, List<BuilderFactory> builderFactories) {
        this.entityTestView = entityTestView;
        this.builderTestView = builderTestView;
        this.containedTestView = containedTestView;
        this.screenStackTestView = screenStackTestView;
        this.typedTestView = typedTestView;
        this.builderFactories = builderFactories;
    }

    @Override
    protected String getRegex() {
        return "Build the \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var name = match[1];

        checkIsTheScreenEntityABuilder();
        checkTheBuildingNameCanBeBuilt(name);

        buildTheBuilding(name);
        goToTheContainerScreen();
    }

    private void buildTheBuilding(String name) {
        builderTestView.build(name);
    }

    private void goToTheContainerScreen() {
        var containerId = containedTestView.getContainerId();
        screenStackTestView.pushScreenName("entity", containerId);
    }

    private void checkIsTheScreenEntityABuilder() {
        var entity = entityTestView.getEntity();
        if (!entity.containsKey("buildeableBuildings")) throw entity.errorInEntity(
                "expected to be a builder and have the property 'buildeableBuildings'.\n"+
                        "Check that it is a real builder (has a Builder component)",
                "buildeableBuildings"
        );
    }

    private void checkTheBuildingNameCanBeBuilt(String name) {
        var exists = builderFactories.stream().anyMatch(f -> f.getName().equals(name));
        if (!exists) throw new AssertionError(
                "There is no @Component implementing BuilderFactory for the name '" + name + "'.\n" +
                        availableImplementations() + "\n" +
                        "You may create a new @Component implementing BuilderBuildingFactory with the corresponding getName().\n" +
                        "Look inside com.drpicox.game.entities.{buildings,decks}.factories, you may want to add one."
        );

        var buildeableType = typedTestView.getType();
        var buildeableBuildings = builderTestView.getBuildeableBuildings();
        if (!buildeableBuildings.contains(name)) throw new AssertionError(
                "The buildeableBuildings of the entity '"+screenStackTestView.peekId()+"' do not contains the builder '"+name+"'.\n"+
                        "Available builders for a '"+buildeableType+"' are:" +
                        buildeableBuildings.stream().map(b -> "\n- " + b).collect(Collectors.joining()) +"\n"+
                        availableImplementations() + "\n" +
                        "You may modify check that getType returns the correct type for."
        );
    }

    private String availableImplementations() {
        return "Available implementations are:" +
                builderFactories.stream().map(
                        f -> "\n- " + f.getName() + " for " + f.getType() + " (" + f.getClass().getName() + ")"
                ).collect(Collectors.joining());
    }
}
