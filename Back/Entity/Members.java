package sut.sa.g15.entity;

import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Members {
    @Id
    @Column(name = "MEMBERS_USER")
    private @NonNull String memUser;
    private @NonNull String memPass;

    public Members() { }

    public Members(String memUser, String memPass ) {
        this.memUser = memUser;
        this.memPass = memPass;
    }

    public String getMemUser() {
        return memUser;
    }

    public void setMemUser(String memUser) {
        this.memUser = memUser;
    }

    public String getMemPass() {
        return memPass;
    }

    public void setMemPass(String memPass) {
        this.memPass = memPass;
    }

}



