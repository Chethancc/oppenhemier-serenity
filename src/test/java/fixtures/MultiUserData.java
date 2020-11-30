package fixtures;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Constant;
import constants.ContextKey;
import fileReaders.CsvReader;
import model.request.UserRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static constants.ContextKey.*;

public class MultiUserData {


    public static String getMultipleUserData(List<String> Profilelist) {
        List<UserRequest> userRequestData = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        String allUserData = null;
        for (String profile : Profilelist) {
            Map<String, String> userProfile = new HashMap<>();
            UserRequest userRequest = new UserRequest();
            userProfile = CsvReader.getData(Constant.testFileData, profile);
            userRequest.setBirthday(userProfile.get(ContextKey.birthday.toString()));
            userRequest.setGender(userProfile.get(ContextKey.gender.toString()));
            userRequest.setNatid(userProfile.get(ContextKey.natid.toString()));
            userRequest.setTax(userProfile.get(ContextKey.tax.toString()));
            userRequest.setName(userProfile.get(ContextKey.name.toString()));
            userRequest.setSalary(userProfile.get(ContextKey.salary.toString()));
            userRequestData.add(userRequest);
        }
        try {
            allUserData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(userRequestData);
        } catch (JsonProcessingException je) {
            je.printStackTrace();
        }
        return allUserData;
    }
}
