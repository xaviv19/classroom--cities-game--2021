package com.drpicox.game.games.api;

import com.drpicox.game.JsonDeserializerWithInheritance;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;
import java.util.Map;

@JsonAdapter(JsonDeserializerWithInheritance.class)
public abstract class AbstractResponse {

}
