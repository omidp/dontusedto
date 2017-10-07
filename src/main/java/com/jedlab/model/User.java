package com.jedlab.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "t_user")
public class User extends UserVO
{

    @Transient
    public String getExpiredYesNo()
    {
        if (getExpired() != null && getExpired())
            return "Y";
        else
            return "N";
    }
}
