package mapper;

import com.example.Userms.dto.CommentDTO;
import com.example.Userms.dto.PostDTO;
import com.example.Userms.external.Comment;
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

    public static CommentDTO toCommentDTO(Comment comment)
    {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        dto.setImages(comment.getImages());
        return dto;

    }
}
