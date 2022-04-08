package com.c.refactoring.menuexamples;

import java.util.List;

public class MenuAccess {

    public void setAuthorizationsInEachMenus(
            List<MenuItem> menuItems, Role[] roles) {
        if (roles == null) {
            return;
        }

        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem menuItem = menuItems.get(i);
            final String readAccessRole = menuItem
                    .getReadAccessRole();
            final String writeAccessRole = menuItem
                    .getWriteAccessRole();
            for (int j = 0; j < roles.length; j++) {
                String role = roles[j].getName();

                if (role.equals(writeAccessRole)) {
                    menuItem.setAccess(Constants.WRITE);
                    menuItem.setVisible(true);
                    continue;
                }
                if (role.equals(readAccessRole)) {
                    menuItem.setAccess(Constants.READ);
                    menuItem.setVisible(true);
                }
            }

        }

    }

}
