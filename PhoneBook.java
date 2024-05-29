import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook{
    
    private Map<String, List<String>> contacts;
    
    public PhoneBook(){
        contacts=new HashMap<>();

    }
    public void addContact(String name, String phone){
        if(contacts.containsKey(name)){
            List<String> phones=contacts.get(name);
            if(!phones.contains(phone)){
                phones.add(phone);

            }

        }else{
            List<String> phones=new ArrayList<>();
            phones.add(phone);
            contacts.put(name, phones);        
        }
        
    }
    
    public void printContacts(boolean sort){
        if(sort){
            sortContacts();
        }
        System.out.println("Contacts:");
        for(Map.Entry<String, List<String>>entry:contacts.entrySet()){
            String name=entry.getKey();
            List<String> phones=entry.getValue();
            System.out.println(name + " - " + phones.size() + "phones:");
            for(String phone : phones){
                System.out.println("t" + phone);
            }
        }
    }


   
    private void sortContacts(){
        
        contacts.entrySet().stream()
                .sorted(Map.Entry.<String, List<String>>comparingByValue(Comparator.comparingInt(value->value.size())).reversed())          
                .forEachOrdered(x -> contacts.put(x.getKey(), x.getValue()));
    }
    public static void main(String[] args){
        PhoneBook phoneBook=new PhoneBook();
        phoneBook.addContact("Aidar","0557-123-678");
        phoneBook.addContact("Aidar","0500987632");
        phoneBook.addContact("daniar","0530987632");
        phoneBook.printContacts(true);
    }
}


