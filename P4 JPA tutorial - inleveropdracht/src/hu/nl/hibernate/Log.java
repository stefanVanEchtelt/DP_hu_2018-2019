package hu.nl.hibernate;

public class Log {
    private int id;
    private String message;

    public Log() {
    }

    public Log(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", message='" + message + '\'' +
                '}';
    }
}
