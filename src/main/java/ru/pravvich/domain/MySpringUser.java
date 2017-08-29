package ru.pravvich.domain;

import java.util.List;

/**
 * Author : Pavel Ravvich.
 * Created : 29.08.17.
 */
public class MySpringUser  extends User {

    /**
     * This is my own user definition, where all my custom fields are defined.
     */
    private User user;

    /**
     * The constructor expect for myUser and then I call the super.
     * Constructor to fill the basic fields that are mandatory for spring.
     * Security in order to perform the authentication process.
     */
    public MySpringUser(User myUser, List<Role> authorities) {
        super(myUser.getUsername(), myUser.getPassword(),
                authorities, myUser.isEnabled()
                , true, true, true);

        this.setUser(myUser);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * This is an example of how to get custom fields a custom id for example.
     */
    public int getId(){
        return this.getUser().getId();
    }
}
