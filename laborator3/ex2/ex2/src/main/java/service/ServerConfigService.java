package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.UtilService;

@Service
public class ServerConfigService {

//    @Autowired
    private UtilService utilService;

    public ServerConfigService(UtilService utilService) {
        this.utilService = utilService;
    }

    public UtilService getUtilService() {
        return utilService;
    }
}
