import flet as ft

class IconBtn(ft.IconButton):
    
    def __init__(self, icon = None, icon_color = None, icon_size = None, selected = None, selected_icon = None, selected_icon_color = None, bgcolor = None, highlight_color = None, style = None, content = None, autofocus = None, disabled_color = None, hover_color = None, focus_color = None, splash_color = None, splash_radius = None, alignment = None, padding = None, enable_feedback = None, url = None, url_target = None, mouse_cursor = None, visual_density = None, size_constraints = None, on_click = None, on_focus = None, on_blur = None, on_long_press = None, on_hover = None, ref = None, key = None, width = None, height = None, left = None, top = None, right = None, bottom = None, expand = None, expand_loose = None, col = None, opacity = None, rotate = None, scale = None, offset = None, aspect_ratio = None, animate_opacity = None, animate_size = None, animate_position = None, animate_rotation = None, animate_scale = None, animate_offset = None, on_animation_end = None, tooltip = None, badge = None, visible = None, disabled = None, data = None, adaptive = None):
        super().__init__(icon, icon_color, icon_size, selected, selected_icon, selected_icon_color, bgcolor, highlight_color, style, content, autofocus, disabled_color, hover_color, focus_color, splash_color, splash_radius, alignment, padding, enable_feedback, url, url_target, mouse_cursor, visual_density, size_constraints, on_click, on_focus, on_blur, on_long_press, on_hover, ref, key, width, height, left, top, right, bottom, expand, expand_loose, col, opacity, rotate, scale, offset, aspect_ratio, animate_opacity, animate_size, animate_position, animate_rotation, animate_scale, animate_offset, on_animation_end, tooltip, badge, visible, disabled, data, adaptive)
        
        
        self._id = 0
        self.icon = ft.Icons.CONTENT_PASTE_SEARCH
        self.icon_color = "D33F49"
        
    
    def set_id(self,i):
        self._id=i