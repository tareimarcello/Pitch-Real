package exception;
//Eccezione che lancio quando la mail o la pssword risultano errate
    public class CredentialException extends Exception{
        private static final long serialVersionUID = 3L;

        public CredentialException (String message){
            super(message);
        }
        public CredentialException (Throwable cause) {
            super(cause);
        }

        public CredentialException (String message, Throwable cause) {
            super(" +++ " + message + " +++ ", cause);
        }
    }
