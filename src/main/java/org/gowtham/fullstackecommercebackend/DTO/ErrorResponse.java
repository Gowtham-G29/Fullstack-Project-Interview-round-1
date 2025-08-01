package org.gowtham.fullstackecommercebackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {

   private String message;
   private HttpStatusCode status;

}
