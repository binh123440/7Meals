package com.example.cdpm_7meals.data;

public class UserSingleton {
    private static UserSingleton instance;
    private String username;

    private UserSingleton() {
        // Private constructor để ngăn chặn việc tạo đối tượng từ bên ngoài
    }

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
