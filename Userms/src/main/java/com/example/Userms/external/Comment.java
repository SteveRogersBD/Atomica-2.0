package com.example.Userms.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private List<String> images;

    private Long userId;

    private Long postId;

}
