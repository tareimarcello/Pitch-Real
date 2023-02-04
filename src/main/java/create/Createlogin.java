package create;


import applicationcontroller.Logincontroller;

/* Questa classe ha responsabilità di factory e di information expert per gli ogggetti definiti nella sezione attributi
 */
public class Createlogin {
    private static Createlogin instance;

    private  Logincontroller controller;

    public Logincontroller createController() {
            controller = new Logincontroller();
            return controller;
    }

    public static Createlogin getInstance() {
        if (Createlogin.instance == null)
            Createlogin.instance = new Createlogin();
        return instance;
    }
    public Logincontroller getcontroller(){
        return this.controller;
    }
}
