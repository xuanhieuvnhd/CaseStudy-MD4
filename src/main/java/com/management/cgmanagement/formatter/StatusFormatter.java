//package com.management.cgmanagement.formatter;
//
//import com.management.cgmanagement.model.entity.Status;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.Formatter;
//
//import java.security.Provider;
//import java.text.ParseException;
//import java.util.Locale;
//import java.util.Optional;
//
//public class StatusFormatter implements Formatter<Status> {
//    private IStatusService statusService;
//
//    @Autowired
//    public StatusFormatter(IStatusService  statusService){
//        this.statusService=statusService;
//    }
//    @Override
//    public Status parse(String text, Locale locale)throws ParseException{
//        Optional<Status> statusOptional= statusService.findById(Long.parseLong(text));
//        return statusOptional.orElse(null);
//    }
//    @Override
//    public String print(Status object, Locale locale) {
//        return "[" + object.getId() + ", " +object.getName() + "]";
//    }
//}
