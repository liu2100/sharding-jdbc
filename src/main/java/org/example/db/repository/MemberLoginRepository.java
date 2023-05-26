package org.example.db.repository;

import org.example.db.entity.MemberLoginLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liudaojian
 */
@Repository
public interface MemberLoginRepository extends JpaRepository<MemberLoginLog, Integer> {

}
