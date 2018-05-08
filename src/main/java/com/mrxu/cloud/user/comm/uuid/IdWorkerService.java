package com.mrxu.cloud.user.comm.uuid;

import com.mrxu.cloud.user.comm.util.RandomUtils;
import com.mrxu.cloud.user.comm.util.UuidUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author ifcousing-xujia
 * @since 2017/8/29
 */
@Service
public class IdWorkerService implements IdWorker {

    private static final long serialVersionUID = 1343040735688444130L;

    private final SnowFlake snowFlake;

    public IdWorkerService(@Value("${uuid.data_center_id}") Long dataCenterId, @Value("${uuid.machine_id}") Long machineId) {
        super();
        dataCenterId = dataCenterId == null ? 10L : dataCenterId;
        machineId = machineId == null ? 10L : machineId;
        snowFlake = new SnowFlake(dataCenterId, machineId);
    }

    @Override
    public String genVerifyCode() {
        return RandomUtils.getRandomString(4);
    }

    @Override
    public Long getNextId() {
        return snowFlake.nextId();
    }

    @Override
    public Long currentTimeMillis() {
        return snowFlake.getNextMill();
    }

    @Override
    public String getNextIdOfString() {
        return UuidUtils.numericToString(snowFlake.nextId(), 62);
    }

}
