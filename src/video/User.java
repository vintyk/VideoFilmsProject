package video;

/**
 * Created by User on 28.03.2017.
 */
public class User {
    private String nickNameUser;
    private String passwordUser;
    private String nameUser;
    private String familyUser;
    private String snameUser;
    private String eMailUser;
    private String comment;
    private boolean flagUserAuth;

    public String getNickNameUser() {
        return nickNameUser;
    }

    public void setNickNameUser(String nickNameUser) {
        this.nickNameUser = nickNameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getFamilyUser() {
        return familyUser;
    }

    public void setFamilyUser(String familyUser) {
        this.familyUser = familyUser;
    }

    public String getSnameUser() {
        return snameUser;
    }

    public void setSnameUser(String snameUser) {
        this.snameUser = snameUser;
    }

    public String geteMailUser() {
        return eMailUser;
    }

    public void seteMailUser(String eMailUser) {
        this.eMailUser = eMailUser;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isFlagUserAuth() {
        return flagUserAuth;
    }

    public void setFlagUserAuth(boolean flagUserAuth) {
        this.flagUserAuth = flagUserAuth;
    }
}