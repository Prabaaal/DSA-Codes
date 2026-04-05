class Solution:
    def check(self, a, b, flag):
        xor_nonneg = (a >= 0) ^ (b >= 0)  # exactly one is non-negative
        both_neg = a < 0 and b < 0
        
        return (xor_nonneg and not flag) or (both_neg and flag)