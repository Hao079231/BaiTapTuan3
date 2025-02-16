package vn.ute.baitaptuan3.utils;

import org.springframework.http.HttpStatus;
import vn.ute.baitaptuan3.dto.ApiMessageDto;

public class ApiResponseUtils {
  public static <T> ApiMessageDto<T> responses(String message, T data){
    ApiMessageDto<T> response = new ApiMessageDto<>();
    response.setResult(true);
    response.setMessage(message);
    response.setData(data);
    response.setStatus(HttpStatus.OK);
    return response;
  }
}
