package com.example.storage.service.controller;

import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandre de Souza Jr.
 */
@RestController
public class StorageController {

    // @Autowired
    // private FileService fileService;

    // @PostMapping(value = "/file/add-file", consumes =
    // MediaType.MULTIPART_FORM_DATA_VALUE)
    // public ResponseEntity<?> uploadToFileSystem(@Valid @ModelAttribute FileDto
    // fileDto,
    // BindingResult bindingResult) throws IOException {

    // if (bindingResult.hasErrors()) {
    // List<String> errors = bindingResult.getAllErrors().stream()
    // .map(DefaultMessageSourceResolvable::getDefaultMessage)
    // .collect(Collectors.toList());

    // return ResponseEntity.badRequest().body(errors);
    // }

    // String file = storageService.uploadToFileSystem(fileDto.getFileName(),
    // fileDto.getDescription(),
    // fileDto.getFile());

    // return ResponseEntity.status(HttpStatus.OK).body(file);
    // }

}
