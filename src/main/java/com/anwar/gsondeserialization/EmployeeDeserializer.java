package com.anwar.gsondeserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDeserializer implements JsonDeserializer<Employee> {

    @Override
    public Employee deserialize(JsonElement json, Type typeOfT,
                                JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement jsonDob = jsonObject.get("dob");
        Date dobTime = null;
        try {
            dobTime = new SimpleDateFormat("yyyy-MM-dd").parse(jsonDob.getAsString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    List<Address> addressList= new ArrayList<>();
        JsonArray  addressJSONArray = jsonObject.getAsJsonArray("addresses");
        if (addressJSONArray.size()!=0) {
            for (int i = 0; i < addressJSONArray.size(); i++) {
                JsonObject addressJsonObject =
                        addressJSONArray.get(i).getAsJsonObject();
                Address address = new Address(
                        addressJsonObject.get("houseNumber").getAsString(),
                        addressJsonObject.get("street").getAsString(),
                        addressJsonObject.get("city").getAsString(),
                        addressJsonObject.get("country").getAsString()
                );
                addressList.add(address);
            }
        }
        JsonObject contactJsonObject = jsonObject.get("contact").getAsJsonObject();
        Contact contact = new Contact(
                contactJsonObject.get("mobile").getAsString(),
                contactJsonObject.get("officePhone").getAsString(),
                contactJsonObject.get("housePhone").getAsString()
        );


        return new Employee(
                jsonObject.get("id").getAsInt(),
                jsonObject.get("firstName").getAsString(),
                jsonObject.get("lastName").getAsString(),
                jsonObject.get("email").getAsString(),
                dobTime,
                addressList,
                contact);
    }

}
