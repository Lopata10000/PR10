package com.fanta.userinterface;

import com.fanta.entity.ActorEntity;
import com.fanta.services.ActorService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Authorization {
    public static void authorization(){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ведіть логін");
            String email = scanner.nextLine();
            System.out.println("Ведіть пароль");
            String password = scanner.nextLine();
            ActorEntity actor = new ActorEntity(email, password);

            if (isExistUser(actor) == 1) {
                System.out.println("Авторизація успішна");
                Menu.menu();
            }else if(isExistUser(actor) == 2){
                System.out.println("Не вірний логін або пароль");
                Menu.authorization();
            }

        }catch (Exception ex){
            System.out.println("Проблеми за авторизацією");
        }
    }
    public static int isExistUser(ActorEntity user) throws SQLException {
        List<ActorEntity> users = ActorService.getInstance().getAllActors();
        for(ActorEntity  userList: users){
            if(userList.getEmail().equals(user.getEmail()) && userList.getPassword().equals(user.getPassword())){
                return 1;
            }
        }
        return 2;
    }
}
