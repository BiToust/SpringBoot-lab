package ru.arkkhipov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {

    // Поля для сохранения состояния (RAM)
    private ArrayList<String> myArrayList = new ArrayList<>();
    private HashMap<Integer, String> myHashMap = new HashMap<>();
    private Integer mapKeyCounter = 0;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // 1_Обновление ArrayList
    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "a", defaultValue = "*_*") String a) {
        myArrayList.add(a);
        return String.format("Аргумент '%s' добавлен в ArrayList. Всего элементов: %d", a, myArrayList.size());
    }

    // 2_Отображение ArrayList
    @GetMapping("/show-array")
    public ArrayList<String> showArrayList() {
        return myArrayList;
    }

    // 3_Обновление HashMap
    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "b", defaultValue = "map_default") String b) {
        myHashMap.put(mapKeyCounter, b);
        mapKeyCounter++;

        return String.format("Ключ %d со значением '%s' добавлен в HashMap. Всего элементов: %d", (mapKeyCounter - 1), b, myHashMap.size());
    }

    // 4_Отображение HashMap
    @GetMapping("/show-map")
    public HashMap<Integer, String> showHashMap() {
        return myHashMap;
    }

    // 5_Отображение количества элементов
    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int arraySize = myArrayList.size();
        int mapSize = myHashMap.size();

        return String.format(
                "Количество элементов: ArrayList = %d, HashMap = %d. Сумма: %d",
                arraySize,
                mapSize,
                arraySize + mapSize
        );
    }
}