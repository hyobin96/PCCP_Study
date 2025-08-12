# 풀이 시간: 3시간?
# 시간 복잡도: 1,000,000번
# 코드 설명: 이중 연결 리스트를 만듭니다. cmd에 등장하는 모든 X들의 값을 합친 결과가 1,000,000 이하이기 때문에
#           iterator의 최대 이동 거리는 1,000,000입니다. C와 Z는 삭제와 삽입으로 생각할 수 있습니다.
#           C의 경우 마지막 행에서 삭제할 때를 고려하여 조건문을 작성합니다.
#           Z의 경우 stack에 삭제한 Node를 넣어놓고 pop하여 Node에 저장된 prev와 next를 이용하여 삽입합니다.
#           또한 복구되는 행이 현재 이중 연결 리스트의 가장 앞일 때를 고려하여 조건문을 작성합니다.
#           이 코드에서 iterator는 현재 가리키고 있는 행의 바로 앞의 행을 가리킵니다.
#           하지만 지금 생각해 보면 head와 tail을 별개의 노드로 만들어 작성했기 때문에
#           굳이 그럴 필요는 없었던 것 같습니다.
# 취약한 부분: 처음 문제를 보고 바로 이중 연결 리스트임을 알았으나 제한사항에 모든 이동거리의 합이 1,000,000 이하인
#             경우만 입력으로 주어진다는 조건을 읽지 않았습니다. 그로 인해 세그먼트 트리를 작성하는 등 삽질을 했습니다.
#             피곤하고 귀찮더라도 문제를 꼼꼼히 읽는 것이 오히려 시간을 절약하는 방법입니다.

class Node:
    def __init__(self, index):
        self.index = index
        self.prev = None
        self.next = None
        
class DoublyLinkedList:
    def __init__(self):
        self.head = Node(-1)
        self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.prev = self.head
        
    def push_back(self, index):
        node = Node(index)
        prev_node = self.tail.prev
        prev_node.next = node
        node.prev = prev_node
        node.next = self.tail
        self.tail.prev = node
            
    def delete(self, iterator):
        curr_row_node = iterator.next
        next_row_node = curr_row_node.next
        iterator.next = next_row_node
        next_row_node.prev = iterator
        
    def restore(self, node):
        next_row_node = node.next
        prev_row_node = node.prev
        node.next = next_row_node
        next_row_node.prev = node
        prev_row_node.next = node
        node.prev = prev_row_node
        
def solution(n, k, cmd):
    dl = DoublyLinkedList()
    for i in range(n):
        dl.push_back(i)

    iterator = dl.head
    for _ in range(k):
        iterator = iterator.next
    
        
    arr = [0] * n
    stack = []
    for c in cmd:
        c = c.split()
        
        if c[0] == 'U':
            x = int(c[1])
            if iterator == dl.head:
                break
            for _ in range(x):
                iterator = iterator.prev
                
        elif c[0] == 'D':
            x = int(c[1])
            if iterator == dl.tail:
                break
            for _ in range(x):
                iterator = iterator.next
                
        elif c[0] == 'C':
            node = iterator.next
            dl.delete(iterator)
            stack.append(node)
            arr[node.index] = -1
            if iterator.next == dl.tail:
                iterator = iterator.prev
            
        else:
            node = stack.pop()
            dl.restore(node)
            arr[node.index] = 0
            if iterator.next == node:
                iterator = iterator.next
            
    
    answer = []
    for v in arr:
        if v == 0:
            answer.append('O')
        else:
            answer.append('X')
    return ''.join(answer)