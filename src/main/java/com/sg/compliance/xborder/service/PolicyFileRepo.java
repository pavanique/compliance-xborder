package com.sg.compliance.xborder.service;


/**
 * Created by narisp on 4/28/17.
 */
@Component
public class PolicyFileRepo {
    private static final String FILE_DIRECTORY = "D:\\ms121216\";
    
    public void saveFile(Long id, MultipartFile file){
    	Path path = Paths.get(FILE_DIRECTORY+id+"_"+file.getOriginalFilename());
    	try{
    		Files.write(path, file.getBytes());
    	} catch(IOException io){
    		io.printStackTrace();
    	}
    }
    
    public byte[] getFile(Long id, String originalFilename){
    	Path path = Paths.get(FILE_DIRECTORY+id+"_"+originalFilename());
    	try {
    		return Files.readAllBytes(path);
    	} catch(IOException io){
    		e.printStackTrace();
    		return null;
    	}
    }
}
