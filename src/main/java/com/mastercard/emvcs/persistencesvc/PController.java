package com.mastercard.emvcs.persistencesvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.core.env.Environment;

import java.util.List;

@RestController
public class PController {
    int code = 0;
    @Autowired
    private SerialNumberService serialNumberService;

    @Autowired
    SerialNumberRepository serialNumberRepository;

    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String getAllUser() {
        String help = "(" + env.getProperty("datacenter") + ") " + "EMV-CS Persistence Service:" + "</br>" +
                "[GET] /unallocated-sn" + "</br>"  +
                "[POST] /unallocated-sn" + "</br>";
        return help;
    }


    @PostMapping("/unallocated-sn")
    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.POST,
            value = "/unallocated-sn")
    public ResponseEntity<UnallocatedSn> setUnallocatedSn(@RequestBody UnallocatedSn unallocatedSn) {
        try {
            UnallocatedSn _unallocatedSn = serialNumberRepository
                    .save(new UnallocatedSn(
                            unallocatedSn.getRid(),
                            unallocatedSn.getCaPKIdx(),
                            unallocatedSn.getRangeStart(),
                            unallocatedSn.getRangeEnd(),
                            unallocatedSn.getAllocSize(),
                            unallocatedSn.getReallocLevel(),
                            unallocatedSn.getCreatedTimestamp(),
                            unallocatedSn.getModifiedTimestamp()));
            return new ResponseEntity<>(_unallocatedSn, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/unallocated-sn")
    public String listAll(UnallocatedSn UnallocatedSn) {
        String response = null;
        List<UnallocatedSn> list = serialNumberService.getAllUnallocatedSn();
        for (UnallocatedSn row : list) {
            response += row.toString() + "\n";
        }
        return response;
    }
}