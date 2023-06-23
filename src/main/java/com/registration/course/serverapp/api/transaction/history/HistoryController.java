package com.registration.course.serverapp.api.transaction.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.course.serverapp.api.dto.response.ResponseData;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/history")
public class HistoryController {

  @Autowired
  private HistoryService historyService;

  @GetMapping
  public ResponseEntity<ResponseData<History>> getAllTransactions() {
    ResponseData<History> responseData = new ResponseData<>();
    responseData.setStatus(true);
    responseData.getMessages().add("success");
    responseData.setPayload(historyService.getAll());
    return ResponseEntity.ok(responseData);
  }

  @GetMapping("/member/{id}")
  public ResponseEntity<ResponseData<History>> getAllHistoriesByMemberId(@PathVariable Integer id) {
    ResponseData<History> responseData = new ResponseData<>();
    responseData.setStatus(true);
    responseData.getMessages().add("berhasil ditemukan");
    responseData.setPayload(historyService.getAllHistoriesByMemberId(id));
    return ResponseEntity.ok(responseData);
  }

}
