package com.gcc.smartcity.preference;

import com.gcc.smartcity.dashboard.model.NewMissionListModel;
import com.gcc.smartcity.dashboard.model.root.RootApiModel;
import com.gcc.smartcity.leaderboard.LeaderBoardModel;
import com.gcc.smartcity.user.UserModel;
import com.gcc.smartcity.utils.Logger;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SessionStorage {

    private static Gson GSON = new Gson();

    private static volatile SessionStorage sInstance;

    public static synchronized SessionStorage getInstance() {
        if (sInstance == null) {
            sInstance = new SessionStorage();
        }
        return sInstance;
    }

    private SessionStorage() {

    }

    public String getSessionCookies() {
        return Preferences.INSTANCE.getCookieModel();
    }

    public void setSessionCookies(String sessionCookies) {
        Preferences.INSTANCE.setCookieModel(sessionCookies);
    }

    public void setIntroSlidesVisibility(Boolean status) {
        Preferences.INSTANCE.setIntroSlidesStatus(status);
    }

    public Boolean getIntroSlidesVisibility() {
        return Preferences.INSTANCE.getIntroSlidesStatus();
    }

    public void setUserId(String userId) {
        Preferences.INSTANCE.setUserId(userId);
    }

    public String getUserId() {
        return Preferences.INSTANCE.getUserId();
    }

    public void setUserName(String userName) {
        Preferences.INSTANCE.setUserName(userName);
    }

    public String getUserName() {
        return Preferences.INSTANCE.getUserName();
    }

    public String getStringfromObject(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("object is null");
        }
        return GSON.toJson(object);
    }

    public <T> T getObjectfromString(String value, Class<T> a) {
        String gson = value;
        if (gson == null) {
            return null;
        } else {
            try {
                return GSON.fromJson(gson, a);
            } catch (Exception e) {
                throw new IllegalArgumentException("Object stored with key is instanceof other class");
            }
        }
    }

    private String getStringFromArrayList(ArrayList list) {
        String inputString = GSON.toJson(list);
        return inputString;
    }

    private <T> ArrayList<T> getArrayListFromString(String str, Class<T[]> clz) {
        Logger.d("DB VALUE::: " + str);

        T[] result = new Gson().fromJson(str, clz);

        if (result == null) {
            return null;
        }
        return new ArrayList<>(Arrays.asList(result));

    }

    public static <T> List<T> stringToArray(String s, Class<T> clazz) {
        T arr = new Gson().fromJson(s, clazz);
        return Arrays.asList(arr); //or return Arrays.asList(new Gson().fromJson(s, clazz)); for a one-liner
    }

    public void setLeaderBoardModel(LeaderBoardModel leaderBoardModel) {
        Preferences.INSTANCE.setLeaderBoardApiModel(getStringfromObject(leaderBoardModel));
    }

    public LeaderBoardModel getLeaderBoardModel() {
        return getObjectfromString(Preferences.INSTANCE.getLeaderBoardApiModel(), LeaderBoardModel.class);
    }

    public void setLeaderBoardStatus(Boolean status) {
        Preferences.INSTANCE.setLeaderBoardStatus(status);
    }

    public Boolean getLeaderBoardStatus() {
        return Preferences.INSTANCE.getLeaderBoardStatus();
    }

    public void setRootModel(RootApiModel rootModel) {
        Preferences.INSTANCE.setRootModel(getStringfromObject(rootModel));
    }

    public RootApiModel getRootModel() {
        return getObjectfromString(Preferences.INSTANCE.getRootModel(), RootApiModel.class);
    }

    public void setUserModel(UserModel userModel) {
        Preferences.INSTANCE.setUserModel(getStringfromObject(userModel));
    }

    public UserModel getUserModel() {
        return getObjectfromString(Preferences.INSTANCE.getUserModel(), UserModel.class);
    }

    public void setNewMissionListModel(NewMissionListModel newMissionListModel) {
        Preferences.INSTANCE.setNewMissionListModel(getStringfromObject(newMissionListModel));
    }

    public NewMissionListModel getNewMissionListModel() {
        return getObjectfromString(Preferences.INSTANCE.getNewMissionListModel(), NewMissionListModel.class);
    }
}