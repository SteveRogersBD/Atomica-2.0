package mapper;

import com.example.Userms.dto.PostDTO;
import com.example.Userms.external.Post;

public class Mapper {

    public static PostDTO toPostDTO(Post post)
    {
        PostDTO dto = new PostDTO();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCreatedAt(post.getCreatedAt());
        dto.setImages(post.getImages());
        return dto;
    }
}
