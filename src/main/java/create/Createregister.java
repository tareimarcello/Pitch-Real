package create;

import applicationcontroller.Registercontroller;

public class Createregister {
    private static Createregister instance;

    private Registercontroller controller;

    public Registercontroller createController() {
        controller = new Registercontroller();
        return controller;
    }

    public static Createregister getInstance() {
        if (Createregister.instance == null)
            Createregister.instance = new Createregister();
        return instance;
    }
    public Registercontroller getcontroller(){
        return this.controller;
    }
}
