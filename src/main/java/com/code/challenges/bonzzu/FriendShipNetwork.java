package com.code.challenges.bonzzu;

/*
   Given the 2 datasets shown in main() method, get the Network of friendships as follow:
   1: [2,3,4]
   2: [1,6]
   3: [1]
   4: [1]
   5: []
   6: [2]
   9: []
 */

import java.util.Arrays;
import java.util.List;

class FriendShipNetwork {

    static String[] employee_list = new String[] {
            "1,James,Accounting",
            "2,Ary,Administration",
            "3,Vika,Accounting",
            "4,Donnay,Finance",
            "5,Rox,HR",
            "6,Dan,Accounting",
            "9,Jessy,Finance",
    };

    static void main(String[] args) {

        /*
            Variante 1: Devolver la cantidad de empleados por departamento
            Variante 2: Determinar si cada empleado tiene amigos que sean de otro departamento
        */

        String[] friendship_list = new String[]{
                "1,2",
                "1,3",
                "1,4",
                "2,6",
        };
    }

    private static void getFriendShipList(int employeeId, Integer[] friendIds) {

        List<Integer> friendList = Arrays.stream(friendIds).toList();

        List<Integer> filteredFriendIds =
        Arrays.stream(employee_list)
                .filter(employeeRaw -> friendList.contains(Integer.parseInt(employeeRaw.split(",")[0])))
                .map(employeeRaw -> Integer.parseInt(employeeRaw.split(",")[0]) ).toList();


    }
}
