package swm.s3.coclimb.api.adapter.out.instagram.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LongLivedTokenResponseDto {
    @JsonProperty("access_token")
    String longLivedAccessToken;
    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("expires_in")
    Long expiresIn;
}
