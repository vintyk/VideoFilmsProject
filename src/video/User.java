package video;

/**
 * Created by User on 28.03.2017.
 */
public class User {
    private long id;
    private String nickNameUser;
    private String nameUser;
    private String familyUser;
    private String sNameUser;
    private String passwordUser;
    private String privilege;
    private String eMailUser;

    public User(long id, String nickNameUser, String nameUser, String familyUser,
                String sNameUser, String passwordUser, String privilege, String eMailUser) {
        this.id = id;
        this.nickNameUser = nickNameUser;
        this.nameUser = nameUser;
        this.familyUser = familyUser;
        this.sNameUser = sNameUser;
        this.passwordUser = passwordUser;
        this.privilege = privilege;
        this.eMailUser = eMailUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNickNameUser() {
        return nickNameUser;
    }

    public void setNickNameUser(String nickNameUser) {
        this.nickNameUser = nickNameUser;
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

    public String getsNameUser() {
        return sNameUser;
    }

    public void setsNameUser(String sNameUser) {
        this.sNameUser = sNameUser;
    }

    public String getPasswordUser() {
        return passwordUser;
    }

    public void setPasswordUser(String passwordUser) {
        this.passwordUser = passwordUser;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    public String geteMailUser() {
        return eMailUser;
    }

    public void seteMailUser(String eMailUser) {
        this.eMailUser = eMailUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickNameUser='" + nickNameUser + '\'' +
                ", nameUser='" + nameUser + '\'' +
                ", familyUser='" + familyUser + '\'' +
                ", sNameUser='" + sNameUser + '\'' +
                ", passwordUser='" + passwordUser + '\'' +
                ", privilege='" + privilege + '\'' +
                ", eMailUser='" + eMailUser + '\'' +
                '}';
    }
}