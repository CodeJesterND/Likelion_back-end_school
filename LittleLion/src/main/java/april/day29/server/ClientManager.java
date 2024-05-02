package april.day29.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClientManager {
    //클라이언트들을 관리하는 객체.
    //클라이언들을 알고 있어야 한다.

    //자료구조를 고민해보자!!  여러개의 client를 저장하기 위해서 어떤 자료구조가 적합할까??
    //배열, List, Set, Map...
    //1. 배열??  --  고정길이.  클리언트가 몇 명 접속할지 고려하고 만들어야 하므로.. 부적합..
    //2. List<Client>  -- 적합..  (중복을 허용..  ) -- 검색 : O(n) -- 사용자를 검색할 때 모든 사용자를 다 뒤져야 할 수 있어요.
    //3. Set<Client> -- (중복을 허용하지 않는다..)  ??
    //4. Mpa<key,value>  --  key값을 이용해서 단번에 값을 찾아 낼 수 있다는 장점을 갖고 있어요. Map<String,Client>  key로  nickname
    //넣어주면 단번에 찾기 편할 수 있죠??
    Map<String,Client> map = new ConcurrentHashMap<>();

    public void addClient(Client client){
        map.put(client.getNickname(), client);
    }

    public void removeClient(Client client){
        map.remove(client);
    }
}
