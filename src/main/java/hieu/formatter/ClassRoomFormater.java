package hieu.formatter;

import hieu.model.ClassRoom;
import hieu.service.classroom.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class ClassRoomFormater implements Formatter<ClassRoom> {
    private IClassRoomService categoryService;

    @Autowired
    public ClassRoomFormater(IClassRoomService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ClassRoom parse(String text, Locale locale) throws ParseException {
        ClassRoom classRoom = categoryService.findById(Long.parseLong(text));
        return classRoom;
    }


    @Override
    public String print(ClassRoom object, Locale locale) {
        return "[" + object.getId() + ", " + object.getName() + "]";
    }
}
