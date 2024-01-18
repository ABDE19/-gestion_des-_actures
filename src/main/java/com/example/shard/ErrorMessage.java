package com.example.shard;

import java.sql.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level =AccessLevel.PRIVATE )
@Builder
public class ErrorMessage {
    String message;
    Date timestamp;
    Integer code;


}
