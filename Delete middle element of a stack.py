class Solution:
  #Function to delete middle element of a stack.
  def deleteMid(self, s, sizeOfStack):
        # code here
        if sizeOfStack%2 != 0:
            s.pop(sizeOfStack//2)
        else:
            s.pop((sizeOfStack//2)-1)
