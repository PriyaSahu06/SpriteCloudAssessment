package API_Testing.pojo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class AddPet {
        Long id;
        Category category;
        String name;
        List<String> photoUrls;
        List<Tags> tags;
        String status;

        @Getter
        @Setter
        public static class Category {
            private Long id;
            private String name;
        }

        @Getter
        @Setter
        public static class Tags {
            private Long id;
            private String name;
        }
}