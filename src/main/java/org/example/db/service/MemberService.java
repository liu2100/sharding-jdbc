package org.example.db.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import org.example.db.entity.MemberLoginLog;
import org.example.db.repository.MemberLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liudaojian
 */
@Service
public class MemberService {

    @Autowired
    private MemberLoginRepository memberLoginRepository;

    public void addLoginLog() {

        int memberId = 60000000;
        //String datetime = DateUtil.now();
        String datetime = "2023-04-24 16:00:00";

        for (int i = 0; i < 30; i++) {

            MemberLoginLog memberLoginLog = new MemberLoginLog();
            memberLoginLog.setCreatedAt(datetime);
            memberLoginLog.setUpdatedAt(datetime);
            memberLoginLog.setMemberId(memberId + i);
            memberLoginRepository.save(memberLoginLog);

        }

    }

}
