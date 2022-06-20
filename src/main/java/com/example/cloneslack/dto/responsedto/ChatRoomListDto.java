package com.example.cloneslack.dto.responsedto;

import com.example.cloneslack.model.ChatRoom;
import com.example.cloneslack.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ChatRoomListDto {

    private Long id;
    private String chatRoomName;
    private List<String> userList = new ArrayList<>();
    private String nickname;

    private String roomCreator;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public ChatRoomListDto(ChatRoom chatRoom, User user) {
        this.id = chatRoom.getId();
        this.chatRoomName = chatRoom.getChatRoomName();
//        this.userList = chatRoom.getUserList();
        this.userList.add(0,"nickname"+'"'+":"+'"'+user.getNickname());
        this.userList.add(1,"profileUrl"+'"'+":"+'"'+user.getProfileUrl());
        this.nickname = user.getNickname();
        this.roomCreator = chatRoom.getRoomCreator();
        this.createdAt = chatRoom.getCreatedAt();
        this.modifiedAt = chatRoom.getModifiedAt();

    }
}
