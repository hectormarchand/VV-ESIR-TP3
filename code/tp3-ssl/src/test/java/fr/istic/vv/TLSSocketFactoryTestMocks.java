package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import static org.mockito.AdditionalMatchers.*;

public class TLSSocketFactoryTestMocks {
    @Test
    public void preparedSocket_NullProtocols()  {
        // generate mock
        SSLSocket mockedSocket = mock(SSLSocket.class);

        any(Object[].class);
        // stub method calls
        when(mockedSocket.getSupportedProtocols()).thenReturn(null);
        when(mockedSocket.getEnabledProtocols()).thenReturn(null);
        //when(mockedSocket.setEnabledProtocols(any(String[].class))).thenReturn(null);

        assertNull(mockedSocket.getSupportedProtocols());
        assertNull(mockedSocket.getEnabledProtocols());
    }

    @Test
    public void typical() {
        // generate mock
        SSLSocket mockedSocket = mock(SSLSocket.class);

        // stub method calls
        when(mockedSocket.getSupportedProtocols()).thenReturn(shuffle(new String[]{"SSLv2Hello", "SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"}));
        when(mockedSocket.getEnabledProtocols()).thenReturn(shuffle(new String[]{"SSLv3", "TLSv1"}));
        //when(mockedSocket.setEnabledProtocols(aryEq(new String[] {"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3" }))).thenReturn(true);
    }

    private String[] shuffle(String[] in) {
        List<String> list = new ArrayList<String>(Arrays.asList(in));
        Collections.shuffle(list);
        return list.toArray(new String[0]);
    }

}