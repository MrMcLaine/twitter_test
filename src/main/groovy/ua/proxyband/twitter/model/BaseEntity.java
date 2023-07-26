package ua.proxyband.twitter.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
class BaseEntity {
    @Id
    String id;
}
