package com.example.cloneslack.model;

import com.example.cloneslack.dto.requestdto.ChatRoomRequestDto;
import com.example.cloneslack.service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class ChatRoom {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column(name = "chat_room_id")
    private Long id;

    @Column
    private String chatRoomName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<User> userList = new ArrayList<>();

    private String roomCreator;


    public ChatRoom(ChatRoomRequestDto requestDto, UserService userService) {
        this.chatRoomName = requestDto.getChatRoomName();
        this.userList.add(userService.findByNickname(requestDto.getNickname()));
        this.roomCreator = requestDto.getNickname();
    }

    public ChatRoom(String name){
        this.chatRoomName = name;
    }
}
