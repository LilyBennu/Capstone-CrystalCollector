package crystals.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetUrlRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.net.URL;

@RestController
public class ImageUploadController {

    @PostMapping("/crystals/upload")
    public ResponseEntity<String> upload(MultipartFile file) {

        try {
            S3Client s3 = S3Client
                    .builder()
                    .region(Region.US_EAST_2) // correct region
                    .build();

            PutObjectRequest request = PutObjectRequest.builder()
                    .bucket("crystalcollectorbucket") // correct bucket
                    .key(file.getOriginalFilename())
                    .build();

            PutObjectResponse response = s3.putObject(request, RequestBody.fromBytes(file.getBytes()));
            GetUrlRequest imageUrl = GetUrlRequest.builder()
                    .bucket("crystalcollectorbucket")
                    .key(file.getOriginalFilename())
                    .build();

            URL url = s3.utilities().getUrl(imageUrl);
            System.out.println("The URL for  "+file.getOriginalFilename() +" is "+url.toString());

            return new ResponseEntity<>(url.toString(), HttpStatus.CREATED);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return new ResponseEntity(null, HttpStatus.UNPROCESSABLE_ENTITY);

    }
}