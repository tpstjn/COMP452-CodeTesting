import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.function.Consumer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {
    //Using dependency injection
    @Test
    void testInitStatsReader() throws FileNotFoundException {
        StatsFile sFile = new StatsFile(new CSVReaderDummy());
        assertEquals(1, sFile.numGames(3));
    }
}

class CSVReaderDummy extends CSVReader {
    private boolean read;
    CSVReaderDummy() throws FileNotFoundException {
        //Doesn't matter what we do with this
        super(new FileReader("./test/test.txt"));
        read = true;
    }

    //Only method that actually needs to do something
    @Override
    public String[] readNext() {
        if(read) {
            read = false;
            LocalDateTime time = LocalDateTime.now();
            return new String[]{time.toString(), "3"};
        }
        read = true;
        return null;
    }

    //Do nothing
    @Override
    public void forEach(Consumer<? super String[]> action) {

    }
}
