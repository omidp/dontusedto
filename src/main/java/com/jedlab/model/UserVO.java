package com.jedlab.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@MappedSuperclass
public abstract class UserVO extends PO
{

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @Column(name = "is_active")
    @Type(type = "yes_no")
    private Boolean active;

    @Column(name = "is_expired")
    private Boolean expired;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade={CascadeType.ALL})
    private Set<Comment> comments = new HashSet<Comment>();

    public Set<Comment> getComments()
    {
        return comments;
    }

    public void setComments(Set<Comment> comments)
    {
        this.comments = comments;
    }

    public Boolean getExpired()
    {
        return expired;
    }

    public void setExpired(Boolean expired)
    {
        this.expired = expired;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Profile getProfile()
    {
        return profile;
    }

    public void setProfile(Profile profile)
    {
        this.profile = profile;
    }

    public Boolean getActive()
    {
        return active;
    }

    public void setActive(Boolean active)
    {
        this.active = active;
    }

}
