package com.dadok.dadok.freeboard.entity;

import com.dadok.dadok.freeboard.dto.FreeBoardAttachDTO;
import com.dadok.dadok.freeboard.vo.FreeBoardAttachVO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.List;


@Entity
@DynamicUpdate
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "board")
public class FreeBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int board_id;
    private int member_id;
    private Date board_createdAt;
    private Date board_updatedAt;
    private String board_writer;
    private int board_views;
    private String board_title;
    private String board_content;
    private int free_board_no;
    private String nickname;

//    @ElementCollection
//    @CollectionTable(name = "attach", joinColumns = @JoinColumn(name = "board_id"))
//    private List<FreeBoardAttachVO> attachList;

}
