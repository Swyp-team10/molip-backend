package org.example.shallweeatbackend.controller;

import lombok.RequiredArgsConstructor;
import org.example.shallweeatbackend.dto.TeamBoardMenuDTO;
import org.example.shallweeatbackend.entity.TeamBoardMenu;
import org.example.shallweeatbackend.service.TeamBoardMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teamboards")
@RequiredArgsConstructor
public class TeamMenuController {

    private TeamBoardMenuService teamBoardMenuService;

    @Autowired
    public TeamMenuController(TeamBoardMenuService teamBoardMenuService){
        this.teamBoardMenuService = teamBoardMenuService;
    }

    // 메뉴를 팀 메뉴판에 추가
    @PostMapping("/{teamBoardId}/teammenus")
    public ResponseEntity<TeamBoardMenuDTO> addMenuToTeamBoard(
            @PathVariable Long teamBoardId,
            @RequestParam Long menuId) {
        TeamBoardMenu teamBoardMenu = teamBoardMenuService.addMenuToTeamBoard(teamBoardId, menuId);
        TeamBoardMenuDTO teamBoardMenuDTO = teamBoardMenuService.convertToDTO2(teamBoardMenu);
        return ResponseEntity.ok(teamBoardMenuDTO);
    }

    @GetMapping("/{teamBoardId}/teammenuList")
    public ResponseEntity<List<TeamBoardMenuDTO>> showTeamBoardMenuList(@PathVariable Long teamBoardId) {
        List<TeamBoardMenuDTO> teamBoardMenuList = teamBoardMenuService.getTeamBoardMenuList(teamBoardId);
        return ResponseEntity.ok(teamBoardMenuList);
    }




}
