package thrift;

import org.apache.commons.lang3.StringUtils;
import org.apache.thrift.TException;
import thrift.info.HelloWorldService;
import thrift.info.Request;
import thrift.info.RequestException;
import thrift.info.RequestType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lijs
 * on 2017/9/6.
 */
public class HelloWorldServiceImpl implements HelloWorldService.Iface {

    private DateFormat dateFormat = new SimpleDateFormat();

    @Override
    public String doAction(Request request) throws RequestException, TException {
        System.out.println("Get request: " + request);
        if (StringUtils.isBlank(request.getName()) || request.getType() == null) {
            throw new RequestException();
        }
        String result = "Hello, " + request.getName();
        if (request.getType() == RequestType.SAY_HELLO) {
            result += ", Welcome!";
        } else {
            result += ", Now is " + dateFormat.format(new Date());
        }
        return result;
    }
}
