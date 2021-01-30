package com.spring.mobilelele.data.enitites.users;

import com.spring.mobilelele.data.enitites.base.BaseEntity;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class RoleEntity extends BaseEntity implements GrantedAuthority {

    private String authority;

    public RoleEntity() {
    }

    public String getAuthority() {
        return authority;
    }

    public RoleEntity setAuthority(String authority) {
        this.authority = authority;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return authority.equals(that.authority);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authority);
    }

    @Override
    public String toString() {
        return String.format("Role:%n name : %s%n %s",
                this.getAuthority(),
                super.toString());
    }
}
